package com.PEWUE.loyalty_program.service;

import com.PEWUE.loyalty_program.mapper.MembershipMapper;
import com.PEWUE.loyalty_program.repository.MembershipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembershipService {
    private final MembershipRepository membershipRepository;
    private final MembershipMapper membershipMapper;
}
