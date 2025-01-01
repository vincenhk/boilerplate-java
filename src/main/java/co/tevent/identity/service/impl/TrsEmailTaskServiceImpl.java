package co.tevent.identity.service.impl;

import co.tevent.identity.dto.request.UserFormRequestDto;
import co.tevent.identity.model.TrsEmailTask;
import co.tevent.identity.service.TrsEmailTaskService;
import org.springframework.stereotype.Service;

@Service
public class TrsEmailTaskServiceImpl implements TrsEmailTaskService {

    @Override
    public TrsEmailTask createEmailTask(UserFormRequestDto userFormRequestDto) {
        return null;
    }
}