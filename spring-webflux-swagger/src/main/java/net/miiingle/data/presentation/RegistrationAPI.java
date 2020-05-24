package net.miiingle.data.presentation;

import lombok.RequiredArgsConstructor;
import net.miiingle.data.entity.Registration;
import net.miiingle.data.repository.RegistrationRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationAPI {

    private final RegistrationRepository repository;

    @PostMapping
    public Mono<Registration> save(@RequestBody Registration registration) {
        return repository.save(registration);
    }

    @GetMapping(path = "{id}")
    public Mono<Registration> findById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
