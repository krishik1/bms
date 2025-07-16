package com.bms.management.system.service;

import com.bms.management.system.dto.CreateScreenRequest;
import com.bms.management.system.model.Screen;

public interface ScreenServiceI {
    Screen createScreen(CreateScreenRequest createScreenRequest);
    Screen getScreenById(Long id);
}
