package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Service;

@Service
public class MachineLogic {

    public void giveOutTicket(Machine machine, String type) {
        machine.getTicketKeeper().giveOut(type);
    }
}
