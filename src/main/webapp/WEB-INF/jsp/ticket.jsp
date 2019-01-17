<%@ include file="common/header.jspf" %>

<div class="container">
  <div class="row">
    <div class="d-flex flex-column flex-container border border-danger rounded bg-info">
      <div class="p-2 bd-highlight tvm">Ticket Vending Machine</div>
      <div class="col-sm d-flex flex-row justify-content-around">
        <div class="ticket-info">
          <div class="ticket-option">Ticket info:</div>
          <div class="info-option">Type: <span class="argument">${ticketType}</span></div>
          <div class="info-option">Cost: <span class="argument">${ticketCost}</span> Betelgeuse coins</div>
        </div>
        <div class="ticket-logo">
          <img src="${pageContext.request.contextPath}../png/tow.png" alt="towel" id="logo">
        </div>
      </div>
      <div class="col-sm border-top border-danger">
        <div>
          <div class="ticket-option">Left: <span class="argument">${moneyLeft}</span></div>
        </div>
        <div>
          <span>Your input: </span>
          <c:forEach items="${userInputList}" var="userCoinValue">
            <span class="argument">${userCoinValue} |</span>
          </c:forEach>
        </div>
        <form:form method="post" modelAttribute="userCoin">
          <div class="ticket-type">
            <form:input type="number" path="coinValue" step="0.1" min="0" cssClass="coin-input"/>
          </div>
          <div class="ticket-type">
            <form:button type="submit" path="coinValue" class="btn btn-success ticket-type-btn">Insert</form:button>
          </div>
        </form:form>
        <div id="cancel">
          <a href="/index" class="btn btn-danger ticket-type-btn">Cancel</a>
        </div>
      </div>
    </div>
  </div>
</div>

<%@ include file="common/footer.jspf" %>