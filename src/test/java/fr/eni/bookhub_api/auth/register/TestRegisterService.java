package fr.eni.bookhub_api.auth.register;

import fr.eni.bookhub_api.common.dal.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@Transactional
@Slf4j
public class TestRegisterService {

    @Autowired
    private  RegisterService registerService;

    @Autowired
    @MockitoBean
    private UserRepository userRepository;

    @Test
    void registerOneUser() {

        RegisterRequestDTO requestDTO = RegisterRequestDTO.builder()
                .firstName("Marie")
                .lastName("Dupont")
                .email("marie.dupont@mail.com")
                .phone("0612345678")
                .password("Azerty12345&")
                .build();

        Mockito.when(userRepository.existsByEmail("marie.dupont@mail.com")).thenReturn(false);

        registerService.register(requestDTO);

        log.info(requestDTO.toString());

        Assertions.assertThat(requestDTO.getEmail()).isEqualTo("marie.dupont@mail.com");
        Assertions.assertThat(requestDTO.getFirstName()).isEqualTo("Marie");
        Assertions.assertThat(requestDTO.getLastName()).isEqualTo("Dupont");
    }

    @Test
    void registerUserWithExistingEmail() {
        RegisterRequestDTO requestDTO = RegisterRequestDTO.builder()
                .firstName("Marie")
                .lastName("Dupont")
                .email("marie.dupont@mail.com")
                .phone("0612345678")
                .password("Azerty12345&")
                .build();

        Mockito.when(userRepository.existsByEmail("marie.dupont@mail.com")).thenReturn(true);

        log.info("Tentative d'inscription avec l'email : {}", requestDTO.getEmail());

        org.junit.jupiter.api.Assertions.assertThrows(EmailAlreadyUsedException.class, () -> {
            registerService.register(requestDTO);
        });
    }





}
