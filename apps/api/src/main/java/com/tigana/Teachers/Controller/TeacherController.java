package com.tigana.Teachers.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tigana.Teachers.DTO.TeacherRequest;
import com.tigana.Teachers.DTO.TeacherResponse;
import com.tigana.Teachers.Service.TeacherService;
import com.tigana.Utils.UserContext;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = { "/teacher", "/teachers" })
@AllArgsConstructor
@Validated // this is responsible of validating the PathVariable and RequestParams
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping({ "", "/" })
    public ResponseEntity<UUID> create(@RequestBody @Valid TeacherRequest teacherRequest) {
        String userId = UserContext.getCurrentUserId();
        UUID teacherId = teacherService.createTeacher(teacherRequest, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherId);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<TeacherResponse> put(@PathVariable String teacherId,
            @RequestBody @Valid TeacherRequest teacherRequest) {

        String UserId = UserContext.getCurrentUserId();

        TeacherResponse updatedEntity = teacherService.updateTeacher(teacherRequest, UUID.fromString(teacherId),
                UserId);

        return ResponseEntity.ok(updatedEntity);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherResponse> get(@PathVariable UUID teacherId) {

        String UserId = UserContext.getCurrentUserId();

        TeacherResponse entity = teacherService.getTeacher(teacherId, UserId);

        return ResponseEntity.ok(entity);
    };

}
