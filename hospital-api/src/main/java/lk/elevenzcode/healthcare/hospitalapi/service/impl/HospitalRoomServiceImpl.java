package lk.elevenzcode.healthcare.hospitalapi.service.impl;

import lk.elevenzcode.healthcare.commons.service.impl.GenericServiceImpl;
import lk.elevenzcode.healthcare.hospitalapi.domain.HospitalRoom;
import lk.elevenzcode.healthcare.hospitalapi.repository.HospitalRoomRepository;
import lk.elevenzcode.healthcare.hospitalapi.service.HospitalRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class HospitalRoomServiceImpl extends GenericServiceImpl<HospitalRoom> implements HospitalRoomService {
  @Autowired
  private HospitalRoomRepository hospitalRoomRepository;

  @PostConstruct
  private void init() {
    init(hospitalRoomRepository);
  }
}
