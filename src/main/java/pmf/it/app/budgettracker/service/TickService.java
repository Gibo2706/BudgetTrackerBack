package pmf.it.app.budgettracker.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TickService {
	static final Logger LOGGER = Logger.getLogger(TickService.class.getName());
	private static final String uri = "https://budgettrackerback.onrender.com/api/renew";
	
	@Async
	@Scheduled(cron = "0 * * * * *")
	public void renew() throws InterruptedException {
		HttpURLConnection connection = null;
        try {
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                LOGGER.info("Successfully called renew endpoint");
            } else {
                LOGGER.error("Failed to call renew endpoint. Response code: " + responseCode);
            }
        } catch (IOException e) {
            LOGGER.error("Error calling renew endpoint", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
	}
}
