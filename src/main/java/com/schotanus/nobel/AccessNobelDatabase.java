package com.schotanus.nobel;

import java.util.List;
import java.util.UUID;

import com.schotanus.nobel.entity.NobelPrize;
import com.schotanus.nobel.entity.NobelPrizeCategory;
import com.schotanus.nobel.entity.Scientist;
import com.schotanus.nobel.entity.UserAccount;
import com.schotanus.nobel.repository.CountryRepository;
import com.schotanus.nobel.repository.LanguageRepository;
import com.schotanus.nobel.repository.NobelPrizeCategoryRepository;
import com.schotanus.nobel.repository.NobelPrizeLaureateRepository;
import com.schotanus.nobel.repository.TranslationRepository;
import com.schotanus.nobel.repository.UserAccountRepository;
import com.schotanus.nobel.service.NobelService;
import com.schotanus.nobel.service.ScientistService;

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
    CommandLineRunner accessDatabaseScientists(ScientistService service) {
        return args -> {
            log.info("Scientists:");
            List<Scientist> scientists = service.getScientists();
            scientists.forEach(scientist -> {
                log.info(scientist.toString());
                scientist.getNobelPrizes().forEach(nobelPrize -> log.info(nobelPrize.toString()));
            });
        };
    }

    @Bean
    CommandLineRunner accessDatabaseScientist(ScientistService service) {
        return args -> {
            log.info("Single scientist:");
            Scientist scientist = service.getScientist(1L);
            log.info(scientist.toString());
            scientist.getNobelPrizes().forEach(nobelPrize -> log.info(nobelPrize.toString()));
        };
    }

    @Bean
    CommandLineRunner accessDatabaseNobelPrizes(NobelService service) {
        return args -> {
            log.info("Nobel Prizes:");
            List<NobelPrize> nobelPrizes = service.getNobelPrizes();
            nobelPrizes.forEach(nobelPrize -> {
                log.info(nobelPrize.toString());
                nobelPrize.getScientists().forEach(laureate -> log.info(laureate.toString()));
            });
        };
    }

    @Bean
    CommandLineRunner accessNobelServiceByYear(NobelService service) {
        return args -> {
            log.info("Fetch nobel prizes by year using service:");
            List<NobelPrize> nobelPrizes = service.getNobelPrizes(1801);
            for (NobelPrize nobelPrize : nobelPrizes) {
                log.info("{}", nobelPrize);
            }
        };
    }

    @Bean
    CommandLineRunner accessNobelServiceByYearAndCategory(NobelService service) {
        return args -> {
            log.info("Fetch nobel prize by year and category using service:");
            NobelPrize nobelPrize = service.getNobelPrize(1801, new NobelPrizeCategory('1'));
            log.info("{}", nobelPrize);
        };
    }

    @Bean
    CommandLineRunner accessDatabaseNobelPrizeLaureates(NobelPrizeLaureateRepository repository) {
        return args -> {
            log.info("Nobel Prize Laureates:");
            repository.findAll().forEach(nobelPrizeLaureate -> log.info(nobelPrizeLaureate.toString()));
        };
    }

}
