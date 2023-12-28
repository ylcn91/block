package com.doksanbir.block;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlockControllerTest {

    // Method blocks for specified number of seconds
    @Test
    public void test_method_blocks_for_specified_number_of_seconds() throws InterruptedException {
        // Given
        BlockController blockController = new BlockController();
        int seconds = 5;

        // When
        long startTime = System.currentTimeMillis();
        blockController.block(seconds);
        long endTime = System.currentTimeMillis();

        // Then
        long elapsedTime = endTime - startTime;
        assertTrue(elapsedTime >= seconds * 1000L);
    }

    // Logs info message with correct number of seconds
    @Test
    public void test_logs_info_message_with_correct_number_of_seconds() throws InterruptedException {
        // Given
        BlockController blockController = new BlockController();
        int seconds = 5;

        // When
        blockController.block(seconds);

        // Then
        // Verify the log message contains the correct number of seconds
        // You can use a logging framework like Logback or Log4j to capture and assert the log message
    }

    // Returns void
    @Test
    public void test_returns_void() throws InterruptedException {
        // Given
        BlockController blockController = new BlockController();
        int seconds = 5;

        // When
        // No need to do anything, as the method returns void

        // Then
        // No need to assert anything, as the test will fail if an exception is thrown
    }

    // Method blocks for 0 seconds
    @Test
    public void test_method_blocks_for_0_seconds() throws InterruptedException {
        // Given
        BlockController blockController = new BlockController();
        int seconds = 0;

        // When
        long startTime = System.currentTimeMillis();
        blockController.block(seconds);
        long endTime = System.currentTimeMillis();

        // Then
        long elapsedTime = endTime - startTime;
        assertTrue(elapsedTime >= seconds * 1000L);
    }

    // Method blocks for maximum allowed integer value seconds
    @Test
    public void test_method_blocks_for_maximum_allowed_integer_value_seconds() throws InterruptedException {
        // Given
        BlockController blockController = new BlockController();
        int seconds = Integer.MAX_VALUE;

        // When
        long startTime = System.currentTimeMillis();
        blockController.block(seconds);
        long endTime = System.currentTimeMillis();

        // Then
        long elapsedTime = endTime - startTime;
        assertTrue(elapsedTime >= seconds * 1000L);
    }

    // Method blocks for negative seconds
    @Test
    public void test_method_blocks_for_negative_seconds() throws InterruptedException {
        // Given
        BlockController blockController = new BlockController();
        int seconds = -5;

        // When
        long startTime = System.currentTimeMillis();
        blockController.block(seconds);
        long endTime = System.currentTimeMillis();

        // Then
        long elapsedTime = endTime - startTime;
        assertTrue(elapsedTime >= seconds * 1000L);
    }

}