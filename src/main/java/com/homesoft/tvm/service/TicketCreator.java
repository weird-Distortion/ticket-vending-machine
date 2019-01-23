package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Ticket;
import com.homesoft.tvm.model.TicketInterface;

public enum TicketCreator {

    MIN_20 {
        public TicketInterface createNewTicket() {
            return new Ticket("20 min", "2.8");
        }
    },
    MIN_40 {
        public TicketInterface createNewTicket() {
            return new Ticket("40 min", "3.8");
        }
    },
    MIN_60 {
        public TicketInterface createNewTicket() {
            return new Ticket("60 min", "5.0");
        }
    },
    DAY_7 {
        public TicketInterface createNewTicket() {
            return new Ticket("7 days", "48.0");
        }
    };

    public abstract TicketInterface createNewTicket();
}
