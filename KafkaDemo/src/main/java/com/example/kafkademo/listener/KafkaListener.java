package com.example.kafkademo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(
            topics = "my-topic",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(String message, Acknowledgment ack) {
        try {
            log.info("Received message: {}", message);

            // Logic xử lý ở đây
            if (message.contains("fail")) {
                throw new RuntimeException("Xử lý thất bại");
            }

            // ✅ Commit offset nếu xử lý thành công
            ack.acknowledge();

        } catch (Exception e) {
            log.error("Lỗi xử lý message: {}", message, e);
            // Không ack để cho phép retry
            throw e; // Trigger retry hoặc DLQ
        }
    }
}
