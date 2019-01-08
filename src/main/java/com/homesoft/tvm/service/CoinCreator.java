package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Coin;

public enum CoinCreator {

    COIN_0_1 {
      public Coin createNewCoin() {
          return new Coin("0.1");
      }
    },
    COIN_0_2 {
        public Coin createNewCoin() {
            return new Coin("0.2");
        }
    },
    COIN_0_5 {
        public Coin createNewCoin() {
            return new Coin("0.5");
        }
    },
    COIN_1_0 {
        public Coin createNewCoin() {
            return new Coin("1.0");
        }
    },
    COIN_2_0 {
        public Coin createNewCoin() {
            return new Coin("2.0");
        }
    },
    COIN_5_0 {
        public Coin createNewCoin() {
            return new Coin("5.0");
        }
    };

    public abstract Coin createNewCoin();
}
