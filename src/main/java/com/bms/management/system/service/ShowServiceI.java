package com.bms.management.system.service;

import com.bms.management.system.dto.CreateShowRequestDto;
import com.bms.management.system.model.Show;

public interface ShowServiceI {

    Show createShow(CreateShowRequestDto requestDto);
    Show getShowById(Long id);
}
