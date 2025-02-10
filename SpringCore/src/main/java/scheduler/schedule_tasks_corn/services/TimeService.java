package scheduler.schedule_tasks_corn.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class TimeService
{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public String getCurrentTime()
    {
        return dateFormat.format(new Date());
    }
}
