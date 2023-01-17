package com.acmeflix.config;

import com.acmeflix.repository.AccountRepository;
import com.acmeflix.repository.MovieRepository;
import com.acmeflix.repository.TvShowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class BackgroundTasksConfig {

	private static final Logger LOG = LoggerFactory.getLogger(BackgroundTasksConfig.class);

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	TvShowRepository tvShowRepository;

	@Autowired
	AccountRepository accountRepository;

	@Scheduled(initialDelay = 20, fixedRate = 20, timeUnit = TimeUnit.SECONDS)
	public void logNumberOfMovies() {
		LOG.info("Total movies at ({}): {}", LocalDateTime.now(), movieRepository.count());
	}

	@Scheduled(cron = "0/30 * * ? * * ")
	public void logNumberOfTvShows() {
		LOG.info("Total tv shows at ({}): {}", LocalDateTime.now(), tvShowRepository.count());
	}

	@Scheduled(cron = "0/30 * * ? * * ")
	public void logNumberOfAccounts() {
		LOG.info("Total accounts at ({}): {}", LocalDateTime.now(), accountRepository.count());
	}
}
