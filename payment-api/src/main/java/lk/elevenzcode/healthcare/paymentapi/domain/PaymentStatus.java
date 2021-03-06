package lk.elevenzcode.healthcare.paymentapi.domain;

import lk.elevenzcode.healthcare.commons.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by හShaන් සNදීප on 3/27/2020 3:54 PM
 */
@Entity
@Table(name = PaymentStatus.TABLE_NAME)
public class PaymentStatus extends BaseDomain {
  public static final String TABLE_NAME = "payment_status";
  public static final int STATUS_SUCCESS = 1;
  public static final int STATUS_REFUND = 2;

  @Column(name = "name", nullable = false, length = 10)
  private String name;

  public PaymentStatus() {
  }

  public PaymentStatus(Integer id) {
    super(id);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
