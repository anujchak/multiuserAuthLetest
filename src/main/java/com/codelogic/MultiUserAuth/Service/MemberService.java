package com.codelogic.MultiUserAuth.Service;


import com.codelogic.MultiUserAuth.Model.Member;
import com.codelogic.MultiUserAuth.Repository.MemberRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.logging.Logger;
 
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
 
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }
 
    public List<Member> addAllMembers(List<Member> members) {
        return  memberRepository.saveAll(members);
    }
    public Member getMemberByID(int id) {
         return memberRepository.findById(id).orElse(null);
     }
    public Member getMemberByName(String name) {
        return memberRepository.findByName(name);
    }


    public Member updateMember(Member member)
    {
        Member existingPLA = memberRepository.findById(member.getId()).orElse(null);
        System.out.println(member);
        if(existingPLA == null) {
            System.out.println("Member not found");
            return  memberRepository.save(member);
        }else  {

         
            existingPLA.setName(member.getName());
            existingPLA.setGender(member.getGender());
            existingPLA.setDOB(member.getDOB());
            existingPLA.setContactNumber(member.getContactNumber());
            existingPLA.setEmail(member.getEmail());
            existingPLA.setPlan(member.getPlan());
           existingPLA.setPlanCost(member.getPlanCost());
            memberRepository.save(existingPLA);
        }
        return member;
    }
    public boolean deleteMemberByID(int id) {
        Member existingPLA = memberRepository.getById(id);
        if(existingPLA != null) {
            memberRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
    public List<Member>getAllMembers()
    {
        return memberRepository.findAll();
    }
 
}