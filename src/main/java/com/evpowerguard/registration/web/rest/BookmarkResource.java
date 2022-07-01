// package com.evpowerguard.registration.web.rest;

// import com.evpowerguard.registration.service.BookmarkService;
// import com.evpowerguard.registration.web.rest.assembler.BookmarkResourceAssembler;
// import com.evpowerguard.registration.web.rest.dto.BookmarkDTO;
// import com.evpowerguard.registration.web.rest.mapper.BookmarkMapper;

// import java.net.URI;
// import java.net.URISyntaxException;
// import java.util.List;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.web.PagedResourcesAssembler;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.hateoas.MediaTypes;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import java.util.concurrent.ExecutionException;

// /**
//  * REST controller for managing {@link com.evpowerguard.bookmark.domain.Bookmark}.
//  */
// @CrossOrigin("*")
// @RestController
// @RequestMapping(value = "/api/stations", produces = MediaTypes.HAL_JSON_VALUE)
// public class BookmarkResource {

//     private final Logger log = LoggerFactory.getLogger(BookmarkResource.class);

//     @Value("Bookmark")
//     private String applicationName;

//     private final BookmarkService bookmarkService;

//     private final BookmarkMapper bookmarkMapper;

//     private final BookmarkResourceAssembler bookmarkAssembler;
    

//     public BookmarkResource(BookmarkService bookmarkService
//     , BookmarkMapper bookmarkMapper, BookmarkResourceAssembler bookmarkAssembler
//     , PagedResourcesAssembler<BookmarkDTO> assembler) {
//         this.bookmarkService = bookmarkService;
//         this.bookmarkMapper = bookmarkMapper;
//         this.bookmarkAssembler = bookmarkAssembler;
//     }

//     /**
//      * {@code POST  /bookmarks} : Create a new Bookmark.
//      *
//      * @param bookmarkDTO the bookmarkDTO to create.
//      * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bookmarkDTO, or with status {@code 400 (Bad Request)} if the bookmark has already an ID.
//      * @throws URISyntaxException if the Location URI syntax is incorrect.
//      */
//     @PostMapping("/bookmarks")
//     public ResponseEntity<BookmarkDTO> createBookmark(@RequestBody BookmarkDTO bookmarkDTO)
//         throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
//         log.debug("REST request to create Bookmark : {}", bookmarkDTO);

//         BookmarkDTO result = bookmarkMapper.toDto(bookmarkService.createBookmark(bookmarkMapper.toEntity(bookmarkDTO)));

//         // Set Hateoas 
//         result = bookmarkAssembler.toModel(result);

//         return ResponseEntity
//             .created(new URI("/api/stations/bookmarks/" + result.getId()))
//             .body(result);
//     }

//     /**
//      * {@code GET  /bookmarks} : get all the bookmarks.
//      *
//      * @param pageable the pagination information.
//      * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bookmarks in body.
//      */

//     // @Operation(summary = "bookmarks", description = "bookmarks api example")
//     // @ApiResponses({
//     //     @ApiResponse(responseCode = "200", description = "OK"),        
//     //     @ApiResponse(responseCode = "400", description = "Bad Request"),        
//     //     @ApiResponse(responseCode = "404", description = "Not Found"),        
//     //     @ApiResponse(responseCode = "500", description = "Internal Server Error")
//     // })
//     @GetMapping("/bookmarks")
//     public ResponseEntity<List<BookmarkDTO>> getAllBookmarks(Pageable pageable) {        
//         log.debug("REST request to get a page of Bookmarks");

//         Page<BookmarkDTO> page = bookmarkService.findAll(pageable).map(bookmarkMapper::toDto);
        
//         List<BookmarkDTO> bookmarkDTOList = page.getContent();

//         for ( int i=0; i < bookmarkDTOList.size(); i++ )
//         {
//             bookmarkDTOList.get(i).setCountAvailableChargerFast( bookmarkService.countAvailableChargerFast(bookmarkDTOList.get(i).getStationId())  );
//             bookmarkDTOList.get(i).setCountAvailableChargerNormal( bookmarkService.countAvailableChargerNormal(bookmarkDTOList.get(i).getStationId()) );
//             bookmarkDTOList.get(i).setCountBrokenCharger( bookmarkService.countBrokenCharger(bookmarkDTOList.get(i).getStationId()) );
//         }

//         return ResponseEntity.ok().body(page.getContent());
//     }

//     /**
//      * {@code GET  /bookmarks/:id} : get the "id" bookmark.
//      *
//      * @param id the id of the bookmarkDTO to retrieve.
//      * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bookmarkDTO, or with status {@code 404 (Not Found)}.
//      * @throws URISyntaxException
//      */
//     @GetMapping("/bookmarks/id/{id}")
//     public ResponseEntity<BookmarkDTO> getBookmark(@PathVariable Long id) 
//         throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
//         log.debug("REST request to get bookmark : {}", id);
//         BookmarkDTO result = bookmarkMapper.toDto(bookmarkService.findOne(id).get());
        
//         // Set Hateoas 
//         result = bookmarkAssembler.toModel(result);

//         result.setCountAvailableChargerFast(bookmarkService.countAvailableChargerFast(result.getStationId()));
//         result.setCountAvailableChargerNormal(bookmarkService.countAvailableChargerNormal(result.getStationId()));
//         result.setCountBrokenCharger(bookmarkService.countBrokenCharger(result.getStationId()));
        
//         return ResponseEntity.ok().body(result);
//     }

//     /**
//      * {@code GET  /bookmarks/:userId} : get the "userId" bookmark.
//      *
//      * @param userId the userId of the bookmarkDTO to retrieve.
//      * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bookmarkDTO, or with status {@code 404 (Not Found)}.
//      * @throws URISyntaxException
//      */
//     @GetMapping("/bookmarks/userid/{userId}")
//     public ResponseEntity<List<BookmarkDTO>> getBookmarkByUserId(@PathVariable String userId, Pageable pageable) 
//         throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
//         log.debug("REST request to get bookmark : {}", userId);

//         Page<BookmarkDTO> page = bookmarkService.findBookmarkByUserId(userId, pageable).map(bookmarkMapper::toDto);

//         List<BookmarkDTO> bookmarkDTOList = page.getContent();

//         for ( int i=0; i < bookmarkDTOList.size(); i++ )
//         {
//             bookmarkDTOList.get(i).setCountAvailableChargerFast( bookmarkService.countAvailableChargerFast(bookmarkDTOList.get(i).getStationId())  );
//             bookmarkDTOList.get(i).setCountAvailableChargerNormal( bookmarkService.countAvailableChargerNormal(bookmarkDTOList.get(i).getStationId()) );
//             bookmarkDTOList.get(i).setCountBrokenCharger( bookmarkService.countBrokenCharger(bookmarkDTOList.get(i).getStationId()) );
//         }
        
//         return ResponseEntity.ok().body(page.getContent());

//     }

//     /**
//      * {@code DELETE  /bookmarks/:id} : delete the "id" bookmark.
//      *
//      * @param id the id of the bookmarkDTO to delete.
//      * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//      */
//     @DeleteMapping("/bookmarks/{id}")
//     public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) throws URISyntaxException, InterruptedException, ExecutionException, JsonProcessingException {
//         log.debug("REST request to delete ChargingStation : {}", id);
//         bookmarkService.delete(id);
//         return ResponseEntity
//             .noContent()
//             .build();
//     }
// }
