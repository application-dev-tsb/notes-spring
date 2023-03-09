package dev.codefactory.springdataaccess.adapters.dynamodb.migration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DynamoDBIndexCreator implements ApplicationListener<ContextRefreshedEvent> {

    private final DynamoDbClient client;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String tableName = "orders";

        log.info("Creating Table...{}", tableName);

        try {
            var tableDescription = client.describeTable(DescribeTableRequest.builder()
                    .tableName(tableName)
                    .build());
            if (tableDescription != null) {
                log.warn("Table Already Exist. Skip this Migration");
                return;
            }
        } catch (ResourceNotFoundException resourceNotFoundException) {
            log.info("Table [{}] Does Not Exist. Creating...", tableName);
        }

        List<KeySchemaElement> keySchema = new ArrayList<>();
        keySchema.add(KeySchemaElement.builder().attributeName("PK").keyType(KeyType.HASH).build());
        keySchema.add(KeySchemaElement.builder().attributeName("SK").keyType(KeyType.RANGE).build());

        // Create AttributeDefinitions
        List<AttributeDefinition> attributeDefinitions = new ArrayList<>();
        attributeDefinitions.add(AttributeDefinition.builder().attributeName("PK").attributeType(ScalarAttributeType.S).build());
        attributeDefinitions.add(AttributeDefinition.builder().attributeName("SK").attributeType(ScalarAttributeType.S).build());

        // Create ProvisionedThroughput
        ProvisionedThroughput provisionedThroughput = ProvisionedThroughput.builder()
                .readCapacityUnits(1L)
                .writeCapacityUnits(1L)
                .build();

        var createTableRequest = CreateTableRequest.builder()
                .tableName(tableName)
                .keySchema(keySchema)
                .attributeDefinitions(attributeDefinitions)
                .provisionedThroughput(provisionedThroughput)
                .build();

        client.createTable(createTableRequest);
        log.info("Migration Completed...");
    }
}
