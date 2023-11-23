package food.infra;
import food.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/cookings")
@Transactional
public class CookingController {
    @Autowired
    CookingRepository cookingRepository;



    @RequestMapping(value = "cookings/{id}/acceptoreject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking acceptoreject(@PathVariable(value = "id")  id, @RequestBody AcceptorejectCommand acceptorejectCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/acceptoreject  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.acceptoreject(acceptorejectCommand);
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    



    @RequestMapping(value = "cookings/{id}/start",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking start(@PathVariable(value = "id")  id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/start  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.start();
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    



    @RequestMapping(value = "cookings/{id}/finish",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cooking finish(@PathVariable(value = "id")  id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cooking/finish  called #####");
            Optional<Cooking> optionalCooking = cookingRepository.findById(id);
            
            optionalCooking.orElseThrow(()-> new Exception("No Entity Found"));
            Cooking cooking = optionalCooking.get();
            cooking.finish();
            
            cookingRepository.save(cooking);
            return cooking;
            
    }
    



}
//>>> Clean Arch / Inbound Adaptor
