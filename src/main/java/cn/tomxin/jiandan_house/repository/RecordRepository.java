package cn.tomxin.jiandan_house.repository;

import cn.tomxin.jiandan_house.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    List<Record> findRecordsByOpenId(String openId);

    Page<Record> findAllByOpenId(String openId, Pageable pageable);

    Record findRecordById(String id);

    List<Record> findAllByCreateTimeLessThanEqualAndStatus(LocalDateTime now, Integer status);
}
