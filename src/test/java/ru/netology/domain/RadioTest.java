package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RadioTest {
    Radio radio = new Radio();
    @Test
    void nextChannel() {

        radio.setCurrentStation(0);
        radio.turnNextRadioStation();
        int expected = 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void turnPreviousStation() {
        radio.setMaxStation(22);
        radio.setMinStation(0);
        radio.setCurrentStation(22);
        radio.turnPreviousRadioStation();
        int expected = (21);
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void turnNextIfCurrentIsLastStation() {
        radio.setMaxStation(22);
        radio.setMinStation(0);
        radio.setCurrentStation(22);
        radio.turnNextRadioStation();
        int expected = 0;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void nextChannelafterlast() {
        radio.setMaxStation(22);
        radio.setMinStation(0);
        radio.setCurrentStation(0);
        radio.turnPreviousRadioStation();
        int expected = 22;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }


    @Test
    void channelChoices() {
        radio.chooseCurrentRadioStation(4);
        radio.setMaxStation(22);
        radio.setMinStation(0);
        int expected = 4;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }


    @Test
    void turnUpVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(50);
        radio.turnUpVolume();
        int expected = 51;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void turnDownVolume() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(40);
        radio.turnDownVolume();
        int expected = 39;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void turnUpVolumeIsMax() {
        radio.setMaxVolume(100);
        radio.setMinVolume(0);
        radio.setCurrentVolume(100);
        radio.turnUpVolume();
        int expected = 100;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void turnDownVolumeIsMin() {
        radio.setMinVolume(0);
        radio.setMaxVolume(100);
        radio.setCurrentVolume(0);
        radio.turnDownVolume();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @Test
    void shouldCurrentVolumeHighMax() {
        radio.setMinVolume(0);
        radio.setMaxVolume(100);
        radio.setCurrentVolume(101);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void shouldCurrentVolumeBelowMin() {
        radio.setMinVolume(0);
        radio.setMaxVolume(100);
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }
}
