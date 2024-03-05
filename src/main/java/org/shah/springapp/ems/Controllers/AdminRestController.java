package org.shah.springapp.ems.Controllers;

import org.shah.springapp.ems.Domains.Member;
import org.shah.springapp.ems.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/members")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}
