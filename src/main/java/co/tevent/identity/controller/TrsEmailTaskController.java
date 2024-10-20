package co.tevent.identity.controller;

import co.tevent.identity.controller.base.BaseController;
import co.tevent.identity.dto.ResponseDto;
import co.tevent.identity.dto.request.UserFormRequestDto;
import co.tevent.identity.model.TrsEmailTask;
import co.tevent.identity.service.TrsEmailTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email-task")
@RequiredArgsConstructor
public class TrsEmailTaskController extends BaseController{
    @Autowired
    private final TrsEmailTaskService trsEmailTaskService;


    @PostMapping("/register-email")
    public ResponseEntity<ResponseDto<Object>> registerEmail(@RequestBody UserFormRequestDto requestDto){
        System.out.println("MASUK");
        TrsEmailTask result = trsEmailTaskService.createEmailTask(requestDto);
        return buildResponse(result);
    }
}
