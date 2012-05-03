package de.adorsys.tweetit.server.rest;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.adorsys.tweetit.server.model.Tweet;
import de.adorsys.tweetit.server.model.User;

@Stateless
@Path("/users")
public class UserEndpoint
{
   @PersistenceContext
   private EntityManager em;

   @POST
   @Consumes("application/json")
   public User create(User entity)
   {
      
      em.persist(entity);
      return entity;
   }

   @DELETE
   @Path("/{id}")
   @Produces("application/json")
   public User deleteById(@PathParam("id") String id)
   {
      
      User result = em.find(User.class, id);
      em.remove(result);
      return result;
   }

   @GET
   @Path("/{id}")
   @Produces("application/json")
   public User findById(@PathParam("id") String id)
   {
      return em.find(User.class, id);
   }

   @GET
   @Produces("application/json")
   public List<User> listAll()
   {
      @SuppressWarnings("unchecked")
      final List<User> results = em.createQuery("SELECT x FROM User x").getResultList();
      return results;
   }

   @PUT
   @Path("/{id}")
   @Consumes("application/json")
   public User update(@PathParam("id") String id, User entity)
   {
      entity.setUserId(id);
      entity = em.merge(entity);
      return entity;
   }
   
   @Path("/{userId}/followers/{followerId}")
   @PUT
   public void addFollow(@PathParam("userId") String userId, @PathParam("followerId") String followerId){
	   User self = em.find(User.class, userId);
	   User newFollower = em.find(User.class, followerId);
	   Collection<User> followUsers = self.getFollowUsers();
	   followUsers.add(newFollower);
   }
   
   @GET
   @Path("/{userId}/tweets")
   @Produces("application/json")
   public Collection<Tweet> listFollowingTweets(@PathParam("userId") String userId) {
	   final List<Tweet> results = em.createQuery("SELECT t FROM Tweet t INNER JOIN t.emitter other WHERE other.userId IN (SELECT self.userId FROM User self WHERE self.userId = ?)")
			   .setParameter(1, userId)
			   .getResultList();
	   return results;
   }
   
   @GET
   @Path("/{userId}/my-tweets")
   @Produces("application/json")
   public Collection<Tweet> listMyTweets(@PathParam("userId") String userId) {
	   final List<Tweet> results = em.createQuery("SELECT t FROM Tweet t INNER JOIN t.emitter self WHERE self.userId = ?").setParameter(1, userId).getResultList();
	   return results;
   }
}