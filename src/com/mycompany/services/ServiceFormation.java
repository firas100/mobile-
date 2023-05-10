/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Formation;
import com.mycompany.utils.Statics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author FIRAS
 */
public class ServiceFormation {
     public static ServiceFormation instance = null ;
    
    public static boolean resultOk = true;
    
    
    private ConnectionRequest req;
    
    
      public static ServiceFormation getInstance() {
        if(instance == null )
            instance = new ServiceFormation();
        return instance ;
    }
     public ServiceFormation() {
        req = new ConnectionRequest();
        
    }
     
     public void ajoutForamtion(Formation formation) {
        
        String url =Statics.BASE_URL+"/ajouterJson?titre="+formation.getTitre()+"&description="+formation.getDescription()+"&type="+formation.getType()+"&pays="+formation.getPays()+"&debut="+formation.getDebut()+"&fin="+formation.getFin(); 
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
     
       public ArrayList<Formation>affichageFormation() {
        ArrayList<Formation> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/readJson";
        req.setUrl(url);
        
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp ;
            jsonp = new JSONParser();
            
            try {
                Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");
                
                for(Map<String, Object> obj : listOfMaps) {
                    Formation fo = new Formation();
                    
                    //dima id fi codename one float 5outhouha
                    float id = Float.parseFloat(obj.get("id").toString());
                    
                    String objet = obj.get("titre").toString();
                    
                    String description = obj.get("description").toString();
                    String type = obj.get("type").toString();
                    String pays = obj.get("pays").toString();
                    String debut = obj.get("debut").toString();
                    String fin = obj.get("fin").toString();
                    
                    
                    fo.setId((int)id);
                    fo.setTitre(objet);
                    fo.setDescription(description);
                    fo.setType(type);
                    fo.setPays(pays);
                    fo.setDebut(debut);
                    fo.setFin(fin);
                    
                    //Date
                    result.add(fo);
                    
                    
                    
                }
            
            }catch(Exception ex) {
                
                ex.printStackTrace();
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
       
       
       //delete
       
        public boolean deleteFormation(int id ) {
        String url = Statics.BASE_URL +"/deleteJson/"+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
        
            //Update 

public boolean modifierFormation(Formation formation) {
        


        
        
String url = Statics.BASE_URL + "/UpdateJson/" + formation.getId() 
          + "?titre=" + formation.getTitre() 
          + "&description=" + formation.getDescription() 
          + "&type=" + formation.getType() 
          + "&pays=" + formation.getPays() 
          + "&debut=" + formation.getDebut() 
          + "&fin=" + formation.getFin();   
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }}
