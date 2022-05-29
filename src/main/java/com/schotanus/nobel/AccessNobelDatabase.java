package com.schotanus.nobel;

import java.util.UUID;

import com.schotanus.nobel.entity.UserAccount;
import com.schotanus.nobel.repository.CountryRepository;
import com.schotanus.nobel.repository.LanguageRepository;
import com.schotanus.nobel.repository.NobelPrizeCategoryRepository;
import com.schotanus.nobel.repository.ScientistRepository;
import com.schotanus.nobel.repository.TranslationRepository;
import com.schotanus.nobel.repository.UserAccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AccessNobelDatabase {
    private static final Logger log = LoggerFactory.getLogger(AccessNobelDatabase.class);
    
    @Bean
    CommandLineRunner accessDatabaseCountries(CountryRepository repository) {
        return args -> {
            log.info("Countries:");
            repository.findAll().forEach(country -> log.info(country.toString()));

            log.info("Languages:");
            repository.findAll().forEach(language -> log.info(language.toString()));

        };
    }
 
    @Bean
    CommandLineRunner accessDatabaseLanguages(LanguageRepository repository) {
        return args -> {
            log.info("Languages:");
            repository.findAll().forEach(language -> log.info(language.toString()));
        };
    }

    @Bean
    CommandLineRunner accessDatabaseTranslations(TranslationRepository repository) {
        return args -> {
            log.info("Translations:");
            repository.findAll().forEach(translation -> log.info(translation.toString()));
        };
    }

    @Bean
    CommandLineRunner accessDatabaseInsertUserAccount(UserAccountRepository repository) {
        return args -> {
            log.info("Insert UserAccount:");
            final UserAccount userAccount = new UserAccount();
            userAccount.setName(UUID.randomUUID().toString());
            userAccount.setPassword("password");
            userAccount.setSalt("salt");
            userAccount.setExpires(new java.sql.Date(System.currentTimeMillis()));
            userAccount.setActive(true);
            userAccount.setModifiedBy(1L);

            repository.save(userAccount);
        };
    }

    @Bean
    CommandLineRunner accessDatabaseUserAccounts(UserAccountRepository repository) {
        return args -> {
            log.info("UserAccounts:");
            repository.findAll().forEach(userAccount -> log.info(userAccount.toString()));
        };
    }

    @Bean
    CommandLineRunner accessDatabaseNobelPrizeCategories(NobelPrizeCategoryRepository repository) {
        return args -> {
            log.info("NobelPrizeCategories:");
            repository.findAll().forEach(nobelPrizeCategory -> log.info(nobelPrizeCategory.toString()));
        };
    }

    @Bean
    CommandLineRunner accessDatabaseScientists(ScientistRepository repository) {
        return args -> {
            log.info("Scientists:");
            repository.findAll().forEach(scientist -> log.info(scientist.toString()));
        };
    }

}
