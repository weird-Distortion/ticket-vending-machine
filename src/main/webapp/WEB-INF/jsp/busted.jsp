<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="d-flex flex-column flex-container border border-danger rounded bg-info">
      <div class="p-2 bd-highlight tvm">Ticket Vending Machine</div>
      <div>sir, u got busted!</div>
      <div>
        <img id="lspd-logo" src="${pageContext.request.contextPath}../png/busted.jpg" alt="LSPD">
      </div>
      <div class="ticket-logo"><a href="index" class="btn btn-danger ticket-type-btn">I promise not cheat again</a></div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>