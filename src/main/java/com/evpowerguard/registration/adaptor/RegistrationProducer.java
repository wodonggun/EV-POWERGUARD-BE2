package com.evpowerguard.registration.adaptor;

import com.evpowerguard.registration.domain.event.UserCreated;
import com.evpowerguard.registration.domain.event.UserDeleted;
import com.evpowerguard.registration.domain.event.UserUpdated;
// import com.evpowerguard.registration.domain.event.BreakdownReportSubmitted;
// import com.evpowerguard.registration.domain.event.ChargerBroken;
// import com.evpowerguard.registration.domain.event.BookmarkCreated;
// import com.evpowerguard.registration.domain.event.BookmarkDeleted;
// import com.evpowerguard.registration.domain.event.ChargerRepairCompleted;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;

public interface RegistrationProducer {
    
    /** kafka */
    // void updateChargerStatusToBroken(ChargerBroken chargerBroken) throws ExecutionException, InterruptedException, JsonProcessingException;

    // void updateChargerStatusToAvailable(ChargerRepairCompleted chargerRepairCompleted) throws ExecutionException, InterruptedException, JsonProcessingException;

    // void createBookmark(BookmarkCreated bookmarkCreated) throws ExecutionException, InterruptedException, JsonProcessingException;

    // void deleteBookmark(BookmarkDeleted bookmarkDeleted) throws ExecutionException, InterruptedException, JsonProcessingException;

    void createUser(UserCreated userCreated) throws ExecutionException, InterruptedException, JsonProcessingException;

    void updateUser(UserUpdated userUpdated) throws ExecutionException, InterruptedException, JsonProcessingException;

    void deleteUser(UserDeleted userDeleted) throws ExecutionException, InterruptedException, JsonProcessingException;
}
