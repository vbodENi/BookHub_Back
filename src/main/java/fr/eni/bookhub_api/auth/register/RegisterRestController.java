package fr.eni.bookhub_api.auth.register;

import fr.eni.bookhub_api.common.ServiceResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegisterRestController {

    private RegisterService registerService;

    public RegisterRestController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/api/auth/register")
    //pour forcer à créer le statut 201
    @ResponseStatus(HttpStatus.CREATED)
    //on enveloppe la réponse dans la classe ServiceResponse pour standardiser toutes les réponses
    public ServiceResponse<Void> register(@Valid @RequestBody RegisterRequestDTO requestDTO) {

        registerService.register(requestDTO);

        return new ServiceResponse<>(
                "201",
                "Votre compte a été créé avec succès !"

        );
    }


}
