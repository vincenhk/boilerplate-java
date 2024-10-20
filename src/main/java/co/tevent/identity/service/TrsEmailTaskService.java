package co.tevent.identity.service;

import co.tevent.identity.dto.request.UserFormRequestDto;
import co.tevent.identity.model.TrsEmailTask;

public interface TrsEmailTaskService {
    public TrsEmailTask createEmailTask(UserFormRequestDto userFormRequestDto);
}
