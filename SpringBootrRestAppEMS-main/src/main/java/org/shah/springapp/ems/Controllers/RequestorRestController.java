package org.shah.springapp.ems.Controllers;

import org.shah.springapp.ems.Domains.Member;
import org.shah.springapp.ems.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requestor")
public class RequestorRestController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") long id) {
        Optional<Member> memberData = memberRepository.findById(id);

        if (memberData.isPresent()) {
            return new ResponseEntity<>(memberData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
