package ylp.algorithm.course.algorithmcourse.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SearchRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchRunner.class);

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        LOGGER.info("Run search");
        int[] ints = {1, 2, 3, 4, 5};
        LOGGER.info("Is {} in {} ? {}",1, ints, LinearSearch.hasItem(ints, 1));
        LOGGER.info("Is {} in {} ? {}",6, ints, LinearSearch.hasItem(ints, 6));
    }
}
