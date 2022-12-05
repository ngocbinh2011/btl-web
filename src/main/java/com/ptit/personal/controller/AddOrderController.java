package com.ptit.personal.controller;

import com.ptit.personal.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


@Slf4j
@AllArgsConstructor
@Controller
public class AddOrderController {

    private final IOrderService orderService;

    @Scheduled(fixedDelay = 10000)
    public void scheduler() {
        log.info("[Book Order Application] running...");
    }
}
