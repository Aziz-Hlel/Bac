<!-- add  @Builder.Default for added security mesures, so that schoolMajors is nitilized to an empty list when using builder, it's like more necessary for testing reason and non http calls-->

@Data
@Builder
public class BulkCreateSchoolMajorsRequest {

    @NotEmpty(message = "School majors list cannot be empty")
    @Size(max = 100, message = "Cannot process more than 100 items at once")
    @Valid
    @Builder.Default // Lombok’s @Builder.Default is needed to make sure this default value is used
                     // when using the builder pattern. Without it, the builder overrides your
                     // default with null.

    private final List<SchoolMajorsRequest> schoolMajors = new ArrayList<>();

}

<!-- in the mapper layer, you should still verify if the object is nulland here s the reasons  -->

⚠️ Why Still Do the Null Check in the Mapper?
MapStruct is a low-level transformation layer.
It may be reused in contexts other than HTTP (e.g., unit tests, background jobs, etc.), where you can’t guarantee input is valid or initialized.

Future-proofing.
Someone might bypass controller validation, or the validation contract might change. If you don’t guard the mapper, it becomes a hidden bug surface.

Fail-safe principle (aka defensive programming).
At the mapper level, don’t assume anything. Always validate your inputs.

✔️ Why both? (meaning validation and null condition)
Validation prevents invalid API calls.
Null checks protect against developer misuse or internal bugs.

# java

default List<SchoolMajors> toEntityList(List<SchoolMajorsRequest> requests, UUID schoolId) {
if (requests == null || requests.isEmpty()) { // always add these type of conditions
return List.of();
}
return requests.stream()
.map(req -> toEntity(req, schoolId))
.toList();
}

#
