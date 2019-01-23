package com.homesoft.tvm.service;

import com.homesoft.tvm.model.Coin;
import com.homesoft.tvm.model.CoinInterface;

public enum CoinCreator {

    COIN_0_1 {
      public CoinInterface createNewCoin() {
          return new Coin("0.1 Betelgeuse coin", "0.1");
      }
    },
    COIN_0_2 {
        public CoinInterface createNewCoin() {
            return new Coin("0.2 Betelgeuse coin","0.2");
        }
    },
    COIN_0_5 {
        public CoinInterface createNewCoin() {
            return new Coin("0.5 Betelgeuse coin","0.5");
        }
    },
    COIN_1_0 {
        public CoinInterface createNewCoin() {
            return new Coin("1.0 Betelgeuse coin","1.0");
        }
    },
    COIN_2_0 {
        public CoinInterface createNewCoin() {
            return new Coin("2.0 Betelgeuse coin","2.0");
        }
    },
    COIN_5_0 {
        public CoinInterface createNewCoin() {
            return new Coin("5.0 Betelgeuse coin","5.0");
        }
    };

    public abstract CoinInterface createNewCoin();
}
