
class Player(object):
    def __init__(self,hand, name):
        self.hand = [None, None, None, None, None]
        self.name = str(name)
        
        for card in hand:
            self.hand.append(card)
    def computeTotal(self):
        total = 0
        for card in self.hand:
            if card.cardNo == "A":
                if (total + 11) <= 21:
                    total += 11
                else:
                    total += 1
            else: 
                total += card.value
        return total

            

    def draw(self, deck):
        drawnCard = deck.draw()
        if len(self.hand) < 5:
            self.hand.append(drawnCard)
            print("*"+self.name + " drew " + str(drawnCard))
    def getNonNullHandLength(self):
        count = 0
        for i in range(len(self.hand)):
            if (self.hand[i].value != 0):
                count+= 1
        return count
    
    def checkGameOver(self):
        if self.computeTotal() > 21: 
            return True
        else:
            return False
    
    def clearHand(self, emptyCard):
        self.hand =[emptyCard, emptyCard, emptyCard, emptyCard, emptyCard]

    def printHand(self):
        s1 = ""
        for card in self.hand:
            if(card.value != 0):
                s1 += str(card) + ", "
        print(s1)

class Dealer(Player):
    def decision_maker(self,player,deck):
        while self.computeTotal() < 21:
            if player.computeTotal() > 21 or self.computeTotal() >= 21:
                break
            if self.computeTotal() < 17:
                self.draw(deck)
            elif self.computeTotal() < player.computeTotal() and self.computeTotal() < 21:
                self.draw(deck)
            else:
                break
        self.printHand()
            
    def printHand(self):
        returnStr = ""
        for card in self.hand:
            if card != None:
                returnStr += str(card)
                break
        print(returnStr)

        
            
        
        
