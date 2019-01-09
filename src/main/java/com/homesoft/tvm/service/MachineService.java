package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Machine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    public void giveOutTicket(Machine machine, String type) {
        machine.getTicketKeeper().giveOut(type);
    }

    public void checkForFakeMoney(Machine machine, List<String> userMoney) {
        if (!machine.getChangeKeeper()
                .getMap()
                .keySet()
                .containsAll(userMoney)) {

            System.out.println("There is fake money");
        }
    }

    public String countForChange(Machine machine) {


        return "";
    }
}
