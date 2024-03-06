package org.shah.springapp.ems.Repository;

import org.shah.springapp.ems.Domains.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}