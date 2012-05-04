package de.adorsys.tweetit.server.rest;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.*;
import de.adorsys.tweetit.server.model.Tweet;
import de.adorsys.tweetit.server.model.TweetDTO;
import de.adorsys.tweetit.server.model.User;

@Stateless
@Path("/tweets")
public class TweetEndpoint
{
   @PersistenceContext
   private EntityManager em;

   @POST
   @Consumes("application/json")
   public TweetDTO create(TweetDTO tweet)
   {
	  User user = em.find(User.class, tweet.getUserId());
	  Tweet tweetJPA = new Tweet();
	  tweetJPA.setCdat(new Date());
	  tweetJPA.setEmitter(user);
	  tweetJPA.setMessage(tweet.getMessage());
      em.persist(tweetJPA);
      tweet.setCdat(String.valueOf(tweetJPA.getCdat().getTime()));
      return tweet;
   }

   @GET
   @Path("/{id}")
   @Produces("application/json")
   public Tweet findById(@PathParam("id") Long id)
   {
      return em.find(Tweet.class, id);
   }

   @GET
   @Produces("application/json")
   public List<Tweet> listAll()
   {
      @SuppressWarnings("unchecked")
      final List<Tweet> results = em.createQuery("SELECT x FROM Tweet x").getResultList();
      return results;
   }
  
}