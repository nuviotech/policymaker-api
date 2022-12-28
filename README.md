# PolicyMakerAPI
* Seller<br/>
  For search the seller category wise so hit the get request :( http://localhost:9001/seller/Books ) so they give list of sellers.<br/>
* Marketplace<br/>
  For search the marketpalce category wise so hit the get request : ( http://localhost:9001/marketplace/Pet supplies ) they give the list of marketplace.<br/>
* get product_ref_id<br/>
  get the product_ref_id use the ( localhost:9001/getProductRefId/2{this is category id}/Recorder mp3 {this is product title}/1234{this is user id})
* Add the product reviews <br/>
  use url (POST request) :  localhost:9001/addReviews/PRD_RF_ID_1972737213{product_ref_id}<br/>
  pass the some data related to reviews like <br/>
  {
    "rating": 3.5,
    "feedback": "this is best recorder..",
    "imagUrls": "[{url1},{url2}]",
    "reviwerId": "123e"
  }
* get the purticular product all reviews<br/>
  localhost:9001/getReviews/PRD_RF_ID_1972737213
