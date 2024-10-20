package co.tevent.identity.service.impl;

import co.tevent.identity.dto.request.UserFormRequestDto;
import co.tevent.identity.model.TrsEmailTask;
import co.tevent.identity.service.TrsEmailTaskService;
import co.tevent.identity.utils.jwtUtil;
import org.springframework.stereotype.Service;

@Service
public class TrsEmailTaskServiceImpl implements TrsEmailTaskService {

    @Override
    public TrsEmailTask createEmailTask(UserFormRequestDto userFormRequestDto) {
        // JWT Generate
        try {
            String jwtToken = jwtUtil.generateToken(userFormRequestDto.getEmail(), jwtUtil.toClaims(userFormRequestDto));
            System.out.println("jwtToken : " + jwtToken);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}