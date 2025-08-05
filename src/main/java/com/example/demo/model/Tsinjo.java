package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Tsinjo {
  private long cash;

  public long cashAfterGotDonation(Donation donation) {
    return cash + donation.getPayment().getAmount();
  }

  public long cashAfterGivingHelps(Help help) {
    return cash - help.getAmount();
  }
}
