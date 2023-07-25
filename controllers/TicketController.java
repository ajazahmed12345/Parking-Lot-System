package parkingLot_Practice.controllers;

import parkingLot_Practice.Dtos.IssueTicketRequestDto;
import parkingLot_Practice.Dtos.IssueTicketResponseDto;
import parkingLot_Practice.Dtos.ResponseStatus;
import parkingLot_Practice.models.Ticket;
import parkingLot_Practice.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto request){
        IssueTicketResponseDto response = new IssueTicketResponseDto();
        Ticket ticket;

        try {
            ticket = ticketService.issueTicket(request.getVehicleType(), request.getVehicleNumber(),
                    request.getVehicleOwnerName(), request.getGateId());
        }catch(Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            return response;
        }


        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);
        return response;
    }

}
