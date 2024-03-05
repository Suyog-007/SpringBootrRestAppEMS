package org.shah.springapp.ems.Controllers;

import org.shah.springapp.ems.Domains.Member;
import org.shah.springapp.ems.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requestor")
public class RequestorRestController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Implement other requestor functionalities as needed
}
