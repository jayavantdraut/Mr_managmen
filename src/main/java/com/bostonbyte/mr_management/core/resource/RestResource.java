package com.bostonbyte.mr_management.core.resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collection;

public class RestResource {
    private static final int CREATED = 201;
    protected ResponseEntity created(){
        return ResponseEntity.status(CREATED).build();
    }
    protected ResponseEntity confilct(){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    protected ResponseEntity confilct(String message){

        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }
    protected ResponseEntity notfound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    protected ResponseEntity created(Object entity){
        return ResponseEntity.status(CREATED).body(entity);
    }
    protected ResponseEntity badRequest(Object entity){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity);
    }
    protected ResponseEntity ok(){
              return  ResponseEntity.ok().build();
    }
    protected ResponseEntity ok(Object entity) {
        return ResponseEntity.ok(entity);
    }
    protected ResponseEntity ok(Collection collection) {
        return ResponseEntity.ok(new ItemsResp(collection));
    }

    private class ItemsResp {
        private Collection items;

        private ItemsResp(Collection items) {
            this.items = items;
        }

        public Collection getItems() {
            return items;
        }
    }





}
