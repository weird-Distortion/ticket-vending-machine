<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="col-sm">
      <div>TVM</div>
      <div>Choose ticket: </div>
      <div><a href="/ticket?id=${ticket.ticketId}">1</a></div>
      <div><a href="/ticket?id=${ticket.ticketId}">2</a></div>
      <div><a href="/ticket?id=${ticket.ticketId}">3</a></div>
      <div><a href="/ticket?id=${ticket.ticketId}">4</a></div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>