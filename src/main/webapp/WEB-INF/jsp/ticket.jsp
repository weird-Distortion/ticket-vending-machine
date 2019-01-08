<%@ include file="common/header.jspf" %>

<div class="container">
  <div style="text-align: center">TVM</div>
  <div class="row">
    <div class="col-sm-4">
      left part
      <div>${ticketType}</div>
      <a href="/index">Cancel</a>
    </div>
    <div class="col-sm-2">
      right part
      <form action="#">
        <input type="text" value="test amount"><br>
        <input type="submit" value="Insert">
        <button class="btn btn-primary">buy</button>
      </form>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>