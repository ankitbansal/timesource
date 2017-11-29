package org.springframework.cloud.stream.app.time.source.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.app.annotation.PollableSource;
import org.springframework.cloud.stream.app.trigger.TriggerConfiguration;
import org.springframework.cloud.stream.app.trigger.TriggerProperties;
import org.springframework.cloud.stream.app.trigger.TriggerPropertiesMaxMessagesDefaultOne;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Import;

@EnableBinding(Source.class)
@Import({TriggerConfiguration.class, TriggerPropertiesMaxMessagesDefaultOne.class})
public class TimeSourceConfiguration {

    @Autowired
    private TriggerProperties triggerProperties;

    @PollableSource
    public String publishTime() {
        return "ACCS Custom Message 2: " + new SimpleDateFormat(this.triggerProperties.getDateFormat()).format(new Date());
    }

}
