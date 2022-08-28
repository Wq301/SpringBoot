package com.wq.store.controller;

import com.wq.store.pojo.Address;
import com.wq.store.service.AddressService;
import com.wq.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Description
 *
 * @author WangQian
 * @create 2022-07-17 23:17
 */
@RequestMapping("/address")
@RestController
public class AddressController extends BaseController{
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid=getUidFromSession(session);
        String username=getUsernameFromSession(session);
        addressService.addNewAddress(uid,username,address);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"/", ""})
    public JsonResult<List<Address>> getByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid")Integer aid,
                                       HttpSession session){
        addressService.setDefault(
                aid,
                getUidFromSession(session),
                getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(
                                @PathVariable("aid")Integer aid,
                                HttpSession session){
        addressService.delete(
                            aid,
                            getUidFromSession(session),
                            getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}