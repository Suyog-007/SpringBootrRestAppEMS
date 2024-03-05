package org.shah.springapp.ems.Repository;

import org.shah.springapp.ems.Domains.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByLocationAndExperienceAndStatusAndPositionLevel(String location, Integer experience, String status, String positionLevel);
}
